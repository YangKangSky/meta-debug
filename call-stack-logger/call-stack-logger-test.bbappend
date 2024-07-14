CFLAGS_remove = " -Os -pipe -feliminate-unused-debug-types -fvisibility-inlines-hidden "
CXXFLAGS_remove = " -Os -pipe -feliminate-unused-debug-types -fvisibility-inlines-hidden "

CXXFLAGS_append = " -g -O0 -Wall -rdynamic -std=c++17 -finstrument-functions  "
CXXFLAGS_append = " -fPIC "

CFLAGS_append = " -O0 -g "
CXXFLAGS_append = " -O0 -g "
LDFLAGS_append = " -lcallstack "

# Set the compiler and flags
CXX ?= "g++"

# Append additional headers to be excluded from instrumentation
CPP_STD_INCLUDES := "${STAGING_INCDIR},include/callStack.h,include/unwinder.h,include/types.h,include/format.h,include/prettyTime.h"

CXXFLAGS += "-g -O0 -Wall -rdynamic -std=c++17 -finstrument-functions -finstrument-functions-exclude-file-list=${STAGING_INCDIR}"


TUNE_CCARGS_append += " "
TUNE_LDARGS_append = " -lcallstack "

FILES_SOLIBSDEV = ""
SOLIBS = ".so"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

INSANE_SKIP_${PN} += "file-rdeps dev-so"

DEPENDS += "call-stack-logger"

