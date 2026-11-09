package components.musicplaylist;

import components.standard.Standard;

/**
 *
 * @param <T>
 *            type of track elements
 */
public interface MusicPlaylistKernel<T> extends Standard<MusicPlaylist<T>> {

    /**
     * Adds the track at index.
     *
     * @param pos
     *            the position to add a track to
     * @param track
     *            the track that is being added
     * @updates this.tracks
     *
     * @updates this.current
     *
     * @requires 0 <= pos <= |this.tracks|
     *
     * @ensures the track track will be entered into the playlist at position
     *          pos
     *
     */
    void add(int pos, T track);

    /**
     * Removes and returns the track at index.
     *
     * @param pos
     *            the position of the track to remove
     * @return the track removed
     *
     * @updates this.tracks
     *
     * @updates this.current
     *
     * @requires |this.tracks| > 0
     *
     * @ensures the track at position pos will be returned
     */
    T remove(int pos);

    /**
     * Reports the number of tracks in this.
     *
     * @return the number of tracks in this
     *
     * @ensures length = |this.tracks|
     */
    int length();

    /**
     * Reports the index of the active track.
     *
     * @return the index of the current track
     *
     * @requires |this.tracks| > 0
     *
     * @ensures the returned track is the track currently active
     */
    int currentIndex();

    /**
     * Sets the active track to index.
     *
     * @param pos
     *            The index to set as current
     * @requires 0 <=pos <= |this.tracks|
     *
     * @ensures the current index is set to the index at pos
     */
    void setCurrentIndex(int pos);

    /**
     * Returns whether any track is playing or not.
     *
     * @return true if actively playing, false otherwise
     *
     * @ensures that if a track is playing, it returns true, and vice versa
     */
    boolean isPlaying();

    /**
     * Sets the playback state of this.
     *
     * @param playing
     *            The playback state being set
     * @requires |this.tracks| > 0
     *
     * @ensures that if true, the track will start playing, and vice versa
     */
    void setPlaying(boolean playing);
}
