require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Google Pixel Watch 2"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
COMPATIBLE_MACHINE = "aurora"

SRC_URI = " git://android.googlesource.com/kernel/msm;branch=android-msm-eos-5.15-tm-wear-kr3-pixel-watch;protocol=https \
    file://defconfig \
    file://extracted.dtb \
"

TARGET_ARCH = "aarch64"
TUNE_FEATURES = "${TUNE_FEATURES:tune-cortexa53}"
TUNE_ARCH = "cortexa53"
TUNE_PKGARCH = "aurora"

# insane.bbclass is broken and thinks our OS is "linux-gnueabi"
# (that's not an OS, it's a userspace ABI), but aarch64 only supports
# "linux", so it throws a strange and useless error message.

INSANE_SKIP += "arch"

SRCREV = "1a06d99f511c49656b85a309a937d8ed451b43ae"
LINUX_VERSION ?= "5.15"
PV = "${LINUX_VERSION}+pie"
S = "${WORKDIR}/git"
B = "${S}"

do_install:append() {
    rm -rf ${D}/usr/src/usr/
    install -m 0644 ${WORKDIR}/extracted.dtb ${D}/boot/extracted.dtb
}

inherit mkbootimg-android old-kernel-gcc-hdrs
