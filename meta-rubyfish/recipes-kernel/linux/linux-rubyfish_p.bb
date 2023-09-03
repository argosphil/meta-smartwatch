require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Tic Watch Pro 3 GPS platform"
HOMEPAGE = "https://github.com/mobvoi/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "rubyfish"

SRC_URI = " git://github.com/mobvoi/mobvoi-ticwatch-kernel;branch=mobvoi-android-msm-rover-4.9;protocol=https \
    file://defconfig \
    file://img_info \
    file://0005-initramfs-Don-t-skip-initramfs.patch \
" 

SRCREV = "c428ef3654d52e816308a6cf11009a1742f86c1c"
LINUX_VERSION ?= "4.9"
PV = "${LINUX_VERSION}+pie"
S = "${WORKDIR}/git"
B = "${S}"

do_install:append() {
    rm -rf ${D}/usr/src/usr/
}

inherit mkboot old-kernel-gcc-hdrs
