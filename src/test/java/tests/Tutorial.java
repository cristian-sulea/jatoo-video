package tests;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Tutorial {

	private static final String NATIVE_LIBRARY_SEARCH_PATH = "d:\\Downloads\\vlc-2.2.4-64";

	public static void main(String[] args) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());
	}

	public static void main2(String[] args) {
		boolean found = new NativeDiscovery().discover();
		System.out.println(found);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());
	}
}