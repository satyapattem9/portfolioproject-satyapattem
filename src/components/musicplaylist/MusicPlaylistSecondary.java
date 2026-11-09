package components.musicplaylist;

/**
 * MusicPlaylistSecondary.
 *
 * @param <T>
 *            type of track elements
 */
public abstract class MusicPlaylistSecondary<T> implements MusicPlaylist<T> {

    @Override
    public void play() {
        this.setPlaying(true);
    }

    @Override
    public void next() {
        int current = this.currentIndex();

        if (current + 1 >= this.length()) {
            this.setCurrentIndex(0);
        } else {
            this.setCurrentIndex(current + 1);
        }
    }

    @Override
    public void pause() {
        this.setPlaying(false);
    }

    @Override
    public void previous() {
        int current = this.currentIndex();

        if (current - 1 < 0) {
            this.setCurrentIndex(this.length());
        }

        this.setCurrentIndex(current - 1);
    }

    @Override
    public T currentTrack() {
        int current = this.currentIndex();

        T curTrack = this.remove(current);
        this.add(current, curTrack);

        return curTrack;
    }

    @Override
    public void append(T track) {
        int length = this.length();
        this.add(length, track);
    }

    @Override
    public T removeCurrent() {
        int current = this.currentIndex();
        T curTrack = this.remove(current);

        return curTrack;
    }

    @Override
    public boolean contains(T track) {

    }

    @Override
    public void clearTracks() {

    }
}
