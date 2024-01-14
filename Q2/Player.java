
import java.util.ArrayList;
import java.util.List;

public class Player {
  public enum Mode {
    READY{
      @Override
      public String onPlay(Player player) {
        String action = player.startPlayback();
        player.changeMode(PLAYING);
        return action;
      }

      @Override
      public String onLock(Player player) {
        player.changeMode(LOCKED);
        return "Locked...";
      }
    },
    LOCKED{
      @Override
      public String onPlay(Player player) {
        player.changeMode(READY);
        return "Ready";
      }

      @Override
      public String onLock(Player player) {
        return "Locked...";
      }
    },
    PLAYING{
      @Override
      public String onPlay(Player player) {
        player.changeMode(READY);
        return "Paused...";
      }

      @Override
      public String onLock(Player player) {
        player.changeMode(LOCKED);
        player.setCurrentTrackAfterStop();
        return "Stop playing";
      }

      @Override
      public String onNext(Player player) {
        return player.nextTrack();
      }

      @Override
      public String onPrevious(Player player) {
        return player.previousTrack();
      }
    };

    public String onPlay(Player player){
      throw new RuntimeException();
    }

    public String onLock(Player player){
      throw new RuntimeException();
    }

    public String onNext(Player player) {
      return "Locked...";
    }

    public String onPrevious(Player player) {
      return "Locked...";
    }
  }

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
