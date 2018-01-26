Before ('@display_movie_collection') do
    wait_for_activity("MovieCollectionActivity")
    tap_when_element_exists("* marked:'movie'")
end
