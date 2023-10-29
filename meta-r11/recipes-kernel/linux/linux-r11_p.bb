require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Google Pixel Watch"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "r11"

SRC_URI = " git://android.googlesource.com/kernel/exynos;branch=android-exynos-r11-4.19-android13-wear-kr3-qpr3-dr;protocol=https \
    file://defconfig \
    file://extracted.dtb \
"

TARGET_ARCH = "aarch64"
TUNE_FEATURES = "${TUNE_FEATURES:tune-cortexa53}"
TUNE_ARCH = "cortexa53"
TUNE_PKGARCH = "r11"

# insane.bbclass is broken and thinks our OS is "linux-gnueabi"
# (that's not an OS, it's a userspace ABI), but aarch64 only supports
# "linux", so it throws a strange and useless error message.

INSANE_SKIP += "arch"

SRCREV = "98310c8b8c2a852dd01035d53be963c0faf6795b"
LINUX_VERSION ?= "4.4"
PV = "${LINUX_VERSION}+pie"
S = "${WORKDIR}/git"
B = "${S}"

do_install:append() {
    rm -rf ${D}/usr/src/usr/
    install -m 0644 ${WORKDIR}/extracted.dtb ${D}/boot/extracted.dtb
}

inherit mkbootimg-android old-kernel-gcc-hdrs
