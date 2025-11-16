package com.demo.FFM;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.nio.file.Path;

//Command to build the dll: gcc -shared -o cryptooops.dll crypto.c
public class CryptoSha256 {

	private final MethodHandle sha256Fn;

	public CryptoSha256() {
		Linker linker = Linker.nativeLinker();
		Arena arena = Arena.ofAuto();
		Path libPath = Path.of("D:\\native-libs\\cryptooops.dll").toAbsolutePath();// put the dll in a path which does
																					// not contain any spaces
		SymbolLookup lookup = SymbolLookup.libraryLookup(libPath.toString(), arena);

		sha256Fn = linker.downcallHandle(lookup.findOrThrow("sha256"),
				FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
	}

	public byte[] sha256(byte[] data) throws Throwable {

		try (Arena arena = Arena.ofConfined()) {
			MemorySegment inputSegment = arena.allocateFrom(ValueLayout.JAVA_BYTE, data);
			MemorySegment outputSegment = arena.allocate(32);

			sha256Fn.invoke(inputSegment, data.length, outputSegment);

			return outputSegment.toArray(ValueLayout.JAVA_BYTE);
		}
	}

}
