package tests;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibC;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Tutorial2 {

	private final JFrame frame;

	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

	public static void main(final String[] args) {

		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "d:\\Downloads\\vlc-2.2.4-64");
		LibC.INSTANCE._putenv(String.format("%s=%s", "VLC_PLUGIN_PATH", "d:\\Downloads\\vlc-2.2.4-64\\plugins"));
		
		
//		new NativeDiscovery().discover();
//		System.out.println(LibVlc.INSTANCE.libvlc_get_version());

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Tutorial2(args);
			}
		});
	}

	public Tutorial2(String[] args) {
		
		String[] argsx = {
			    "--video-filter", 
			    "rotate",
			    "rotate-angle",
			    "90"
			};
		
	        frame = new JFrame("My First Media Player");
	        frame.setBounds(100, 100, 600, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
	        frame.setContentPane(mediaPlayerComponent);
	        frame.setVisible(true);
	        mediaPlayerComponent.getMediaPlayer().playMedia("d:\\Google Drive\\Videos\\2015.05.22 - Râșnov, Cheile Râșnoavei\\20150523_120237.mp4");
	    }

}