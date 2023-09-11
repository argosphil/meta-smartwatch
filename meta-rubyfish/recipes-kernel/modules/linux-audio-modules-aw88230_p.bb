SUMMARY = "External audio modules for rubyfish"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://aw882xx.c;md5=4712da0ee869b518a7801dfdc59535b3"
COMPATIBLE_MACHINE = "rubyfish"

inherit module kernel-module-split

SRC_URI = " git://github.com/awinic-driver/aw88230;branch=main;protocol=https \
        file://0001-Make-warnings-non-fatal.patch"
SRCREV = "e14c37c611dfd9f31436287805fe6386c112b1b8"
LINUX_VERSION ?= "4.9"
PV = "${LINUX_VERSION}+pie"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS = "virtual/kernel"

EXTRA_OEMAKE = " KERNEL_SRC="${STAGING_KERNEL_DIR}" M="${S}""

RPROVIDES:${PN} += "kernel-module-audio-aw882xx"
