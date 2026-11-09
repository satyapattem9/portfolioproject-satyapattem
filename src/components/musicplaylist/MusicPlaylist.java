package components.musicplaylist;

/**
 * Enhanced interface for {@code MusicPlaylist}.
 *
 * @param <T>
 *            type of track elements
 */
public interface MusicPlaylist<T> extends MusicPlaylistKernel<T> {

    /**
     * Starts playback.
     *
     * @requires |this.tracks| > 0
     *
     * @ensures that playback starts when called
     */
    void play();

    /**
     * Skips to the next track.
     *
     * @requires |this.tracks| > 0
     *
     * @ensures playback will move onto the next track in the playlist
     */
    void next();

    /**
     * Pauses playback.
     *
     * @ensures playback stops
     */
    void pause();

    /**
     * Goes to the previous track in the playlist.
     *
     * @requires |this.tracks| > 0
     *
     * @ensures the current track will be set to the old previous track
     */
    void previous();

    /**
     * Returns the track currently being played.
     *
     * @return the current track being played
     *
     * @requires |this.tracks| > 0
     *
     * @ensures the track currently being played will be returned
     */
    T currentTrack();

    /**
     * Appends a track to the end of the playlist.
     *
     * @param track
     *            the track to be appended
     * @ensures track track will be appended at the end of playlist
     */
    void append(T track);

    /**
     * Removes the track currently being played from the playlist.
     *
     * @return the track currently being played
     *
     * @requires |this.tracks| > 0
     *
     * @ensures the current track being played is returned
     */
    T removeCurrent();

    /**
     * Reports whether a specified track is present in playlist.
     *
     * @param track
     *            the track whose presence is being checked
     * @return true if track is present in the playlist, false otherwise
     *
     * @ensures that if track track is present in playlist, returns true
     */
    boolean contains(T track);

    /**
     * Clears all the tracks in the playlist.
     *
     * @ensures |this.tracks| = 0
     */
    void clearTracks();
}
