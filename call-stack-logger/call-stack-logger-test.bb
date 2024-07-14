FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SUMMARY = "A simple hello world application"
SECTION = "console/testapp"
LICENSE = "CLOSED"

SRC_URI = " file://hello.cpp "
SRC_URI += " file://run-hello-app.sh "

S = "${WORKDIR}"

do_compile () {
    ${CXX} hello.cpp -o hello ${CXXFLAGS} ${LDFLAGS}
}

do_install () {
    install -d ${D}${bindir}
    install -m 755 ${S}/hello ${D}${bindir}
    install -m 755 ${S}/run-hello-app.sh ${D}${bindir}
}

