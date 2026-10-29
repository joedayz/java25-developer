#!/usr/bin/env bash
# Migración: módulo sin nombre (classpath), módulos automáticos y jdeps.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target

titulo "Construir tres JAR antiguos (sin module-info)"
paso javac -d target/legado/colores legado/colores/com/acme/colores/Ansi.java
paso javac -d target/legado/texto -cp target/legado/colores legado/texto/com/acme/texto/Texto.java
paso javac -d target/legado/fechas legado/fechas/com/acme/fechas/Fechas.java
mkdir -p target/libs target/cp
paso jar --create --file target/cp/colores.jar -C target/legado/colores .
paso jar --create --file target/libs/texto-utils-1.2.jar -C target/legado/texto .
paso jar --create --file target/libs/acme-fechas.jar --manifest manifest-fechas.txt -C target/legado/fechas .

titulo "¿Qué módulo automático deriva Java de cada JAR?"
paso jar --describe-module --file target/libs/texto-utils-1.2.jar
paso jar --describe-module --file target/libs/acme-fechas.jar

titulo "Migración top-down: la app es un módulo con nombre, las bibliotecas van al module path"
paso javac -d target/mods -p target/libs --module-source-path src $(find src -name '*.java')
paso java -p target/mods:target/libs -cp target/cp/colores.jar -m com.joedayz.reportes/com.joedayz.reportes.Main

titulo "Todo en el classpath: module-info.class se ignora y todo es el módulo sin nombre"
paso java -cp target/mods/com.joedayz.reportes:target/libs/texto-utils-1.2.jar:target/libs/acme-fechas.jar:target/cp/colores.jar com.joedayz.reportes.Main

titulo "Un módulo con nombre NO puede requerir el classpath"
falla javac -d target/error --module-source-path src -cp target/libs/texto-utils-1.2.jar:target/libs/acme-fechas.jar $(find src -name '*.java')

titulo "jdeps: analizar dependencias"
paso jdeps -s target/libs/acme-fechas.jar
paso jdeps --module-path target/libs:target/mods -s -m com.joedayz.reportes
paso jdeps --generate-module-info target/generado target/libs/acme-fechas.jar
paso cat target/generado/com.acme.fechas/module-info.java
