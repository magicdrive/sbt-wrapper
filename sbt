#! /usr/bin/env bash

WORK_DIR="$(cd $(dirname $0) && pwd)"


SBT_VERSION=0.13.7
SBT_JAR="${WORK_DIR}/.sbt/boot/v${SBT_VERSION}/sbt/bin/sbt-launch.jar"
SBT_SHELL="${WORK_DIR}/.sbt/boot/v${SBT_VERSION}/sbt/bin/sbt"

mkdir -p "${WORK_DIR}/.sbt/boot/v${SBT_VERSION}/"

if [ ! -r "${SBT_JAR}" ];then
    pushd "${WORK_DIR}/.sbt/boot/v${SBT_VERSION}/"
    wget "https://dl.bintray.com/sbt/native-packages/sbt/${SBT_VERSION}/sbt-${SBT_VERSION}.zip"
    unzip "sbt-${SBT_VERSION}.zip"
    popd
fi

exec  "$SBT_SHELL" "$@"


exit 0
