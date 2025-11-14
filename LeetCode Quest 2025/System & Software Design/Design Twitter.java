class Twitter {

    private static int timeStamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, Tweet> tweets;         // userId -> head tweet
    private Map<Integer, Set<Integer>> follows; // userId -> followees

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timeStamp++);
        newTweet.next = tweets.get(userId);
        tweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time   // max-heap by timestamp
        );

        // include user's own tweets
        if (tweets.containsKey(userId)) {
            pq.offer(tweets.get(userId));
        }

        // include followee tweets
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        for (int f : followees) {
            if (tweets.containsKey(f)) {
                pq.offer(tweets.get(f));
            }
        }

        List<Integer> feed = new ArrayList<>();
        int count = 0;

        while (!pq.isEmpty() && count < 10) {
            Tweet top = pq.poll();
            feed.add(top.id);
            count++;

            if (top.next != null) {
                pq.offer(top.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        follows.computeIfAbsent(followerId, k -> new HashSet<>())
               .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
