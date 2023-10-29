SUMMARY = "A tool to read/write/update android boot images"
HOMEPAGE = "https://android.googlesource.com/platform/system/tools/mkbootimg"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://mkbootimg;beginline=1;endline=14;md5=7b23e8b2786c0da7fb7ff74d45637d54"

SRC_URI = "git://android.googlesource.com/platform/system/tools/mkbootimg;protocol=https;branch=main"
SRCREV = "c528e6732a55b2dc80970618ca17acd82950996d"
S = "${WORKDIR}/git"
PV = "git"

BBCLASSEXTEND = "native"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/gki
    install -m 0755 ${S}/mkbootimg.py ${D}${bindir}
    cp -r ${S}/gki ${D}${bindir}/
}

