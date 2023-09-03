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
    file://0001-dts-Add-rubyfish-device-trees.patch \
    file://0002-mmc-Fix-embedded_sdio_data-duplicate-definition.patch \
    file://0003-video-fbdev-msm-Provide-mdss_dsi_switch_page.patch \
    file://0004-usb-hcd-Handle-when-host-mode-isn-t-available.patch \
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
