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
