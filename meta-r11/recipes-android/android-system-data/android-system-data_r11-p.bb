inherit gettext

SUMMARY = "Downloads the Google Pixel Watch system/vendor folders and installs them for libhybris"
LICENSE = "CLOSED"

# This file was generated. Download the full update from Google,
# extract it, extract the zip file again, simg2img system.img to yield
# system.fs, mount system.fs to system, vendor.img to vendor, run sudo
# tar czvf system-r11-p.tar.gz android-system vendor

SRC_URI = "file://system-r11-p.tar.gz"
PV = "pie"

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
COMPATIBLE_MACHINE = "r11"
INSANE_SKIP:${PN} = "ldflags dev-so already-stripped"
S = "${WORKDIR}"
B = "${S}"

do_install() {
    install -d ${D}/system/
    cp -r android-system/system/* ${D}/system/

    install -d ${D}/vendor/
    cp -r vendor/* ${D}/vendor/
}

do_package_qa() {
}

FILES:${PN} = "/system /vendor"
EXCLUDE_FROM_SHLIBS = "1"
