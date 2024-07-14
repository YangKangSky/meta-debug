DESCRIPTION = "This is the implementation of mfrlib for AMLOGIC"
SECTION = "base"
LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"

DEPENDS = "binutils"
RDEPENDS += "binutils"

BASE_SRC_URI ?= "git://github.com/YangKangSky/call-stack-logger.git;protocol=https"
SRC_URI = " ${BASE_SRC_URI} "

S = "${WORKDIR}/git"


CFLAGS_append = "-O0 -g"

CFLAGS_remove = "-Os -pipe -feliminate-unused-debug-types -fvisibility-inlines-hidden"
CXXFLAGS_remove = "-Os -pipe -feliminate-unused-debug-types -fvisibility-inlines-hidden"

do_compile () {
    oe_runmake -C ${S}/
}

do_install () {
	install -d ${D}${libdir}
	install -d ${D}${bindir}
	install -d ${D}${includedir}
	install -m 0644 ${S}/build/libcallstack.a ${D}${libdir}
	install -m 0644 ${S}/build/libcallstack.so ${D}${libdir}
	install -m 0755 ${S}/build/runDemoWithDynamicLib ${D}${bindir}
	install -m 0755 ${S}/build/runDemoWithStaticLib ${D}${bindir}
	install -m 0644 ${S}/include/*.h ${D}${includedir}
}

FILES_${PN} = "${libdir}/* ${bindir}/*"
FILES_${PN}-dev = "${includedir}/* "
INSANE_SKIP_${PN} = "dev-so ldflags dev-elf"
INSANE_SKIP_${PN}-dev = "dev-so ldflags dev-elf"


