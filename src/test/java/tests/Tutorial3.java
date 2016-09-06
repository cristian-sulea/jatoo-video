package tests;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class Tutorial3 {

	private  JFrame frame;

	private  EmbeddedMediaPlayerComponent mediaPlayerComponent;

	public static void main(final String[] args) {

//		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "d:\\Downloads\\vlc-2.2.4-64");
//		LibC.INSTANCE._putenv(String.format("%s=%s", "VLC_PLUGIN_PATH", "d:\\Downloads\\vlc-2.2.4-64\\plugins"));
		
		
		new NativeDiscovery().discover();
//		System.out.println(LibVlc.INSTANCE.libvlc_get_version());

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Tutorial3(args);
			}
		});
	}

	public Tutorial3(String[] args) {
		
		frame = new JFrame("My First Media Player");
		
		args = new String[] {
			    "--video-filter=rotate", 
			    "--rotate-angle=90"
			};
		
//		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory("--video-filter=transform", "--transform-type=270");
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

		EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
		
		mediaPlayer.setEnableKeyInputHandling(false);
		mediaPlayer.setEnableMouseInputHandling(false);

//	        frame.setResizable(false);  
	        frame.setUndecorated(true);

	        Canvas videoSurface = new Canvas();
	        
//	        WindowsMouseHook mouseHook = new WindowsMouseHook(videoSurface);
//	        mouseHook.start();
	        
	        
//	        c.setBackground(Color.black);
	        final JPanel p = new JPanel();
	        
	        videoSurface.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseDragged(MouseEvent e) {
	        		System.out.println(e);
	        	}
			});

	        p.setLayout(new BorderLayout());

	        p.add(videoSurface, BorderLayout.CENTER);
	        frame.add(p, BorderLayout.CENTER);

	        
	        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(videoSurface));

	        
	        frame.setLocation(650, 200);
	        frame.setSize(800, 600);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);             

	        mediaPlayer.playMedia("d:\\Downloads\\xxx\\The Prodigy - Breathe (HQ).mp4");
	        mediaPlayerFactory.newEmbeddedMediaPlayer().playMedia("d:\\Downloads\\xxx\\The Prodigy - Breathe (HQ).webm");
	        
	        
//	        mediaPlayer.mute(false);
	        
//	        frame.pack();
	        
	        
	        new Thread(){
	        	public void run() {
	        		try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
					}
	        		
//	        		System.out.println(mediaPlayer.getVideoDimension());
	        	}
	        }.start();
	    
	    }

}