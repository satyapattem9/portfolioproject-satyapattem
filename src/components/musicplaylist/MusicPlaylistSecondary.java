package components.musicplaylist;

/**
 * MusicPlaylistSecondary.
 *
 * @param <T>
 *            type of track elements
 */
public abstract class MusicPlaylistSecondary<T> implements MusicPlaylist<T> {

    @Override
    public final void play() {
        this.setPlaying(true);
    }

    @Override
    public final void next() {
        int current = this.currentIndex();

        if (current + 1 >= this.length()) {
            this.setCurrentIndex(0);
        } else {
            this.setCurrentIndex(current + 1);
        }
    }

    @Override
    public final void pause() {
        this.setPlaying(false);
    }

    @Override
    public final void previous() {
        int current = this.currentIndex();

        if (current - 1 < 0) {
            this.setCurrentIndex(this.length());
        }

        this.setCurrentIndex(current - 1);
    }

    @Override
    public final T currentTrack() {
        int current = this.currentIndex();

        T curTrack = this.remove(current);
        this.add(current, curTrack);

        return curTrack;
    }

    @Override
    public final void append(T track) {
        int length = this.length();
        this.add(length, track);
    }

    @Override
    public final T removeCurrent() {
        int current = this.currentIndex();
        T curTrack = this.remove(current);

        return curTrack;
    }

    @Override
    public final boolean contains(T track) {
        int length = this.length();
        boolean playlistContains = false;

        for (int i = 0; i < length; i++) {

            int current = this.currentIndex();

            T curTrack = this.remove(current);
            this.add(current, curTrack);

            if (track == curTrack) {
                playlistContains = true;
            }
        }
        return playlistContains;
    }

    @Override
    public final void clearTracks() {
        int length = this.length();
        for (int i = 0; i < length; i++) {
            this.remove(i);
        }
    }
}
