FILESEXTRAPATHS:prepend:rubyfish := "${THISDIR}/ngfd:"
SRC_URI:append:rubyfish = "file://51-ffmemless.ini"

do_install:append:rubyfish() {
    install -m 0644 ${WORKDIR}/51-ffmemless.ini ${D}/usr/share/ngfd/plugins.d/
}