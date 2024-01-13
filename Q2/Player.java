
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Mode mode;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.mode = Mode.READY;
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeMode(Mode mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode.toString();
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }

	public String onPlay() {
		return mode.onPlay(this);
	}

	public String onLock() {
		return mode.onLock(this);
	}

	public String onNext() {
		return mode.onNext(this);
	}

	public String onPrevious() {
		return mode.onPrevious(this);
	}
}
