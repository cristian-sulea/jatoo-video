package tests;


import uk.co.caprica.vlcj.component.AudioMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;

/**
 * The smallest amount of code to play an audio file.
 * <p>
 * Audio is simple since there's no video surface to worry about (unless you want the audio
 * visualisations).
 */
public class Mp3Test  {

    public static void main(String[] args) throws Exception {
    	
    	args = new String[] {"xxx"};
    	
        if(args.length != 1) {
            System.out.println("Specify an MRL to play");
            System.exit(1);
        }

        AudioMediaPlayerComponent audioPlayer = new AudioMediaPlayerComponent() {
            @Override
            public void finished(MediaPlayer mediaPlayer) {
                System.exit(0);
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                System.out.println("Failed to play media");
                System.exit(1);
            }
        };

        // Play the MRL specified by the first command-line argument
        audioPlayer.getMediaPlayer().playMedia(args[0]);
        // Wait forever
        Thread.currentThread().join();
    }
}