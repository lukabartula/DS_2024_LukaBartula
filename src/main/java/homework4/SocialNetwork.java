package homework4;

import java.util.*;

public class SocialNetwork {
    private int V; // Number of vertices - users
    private int E; // Number of edges - friendships

    private HashMap<String, ArrayList<Friendship>> adj; // Adjacency list to store friendships using HashMap

    // Default constructor without edges and vertices, initializes empty social network
    public SocialNetwork() {
        this.adj = new HashMap<>();
    }

    // Constructor that takes a Scanner input to read data
    public SocialNetwork(Scanner in) {
        // Initialize the adjacency list
        this.adj = new HashMap<>();
        boolean isFirstLine = true; // To skip the first line in csv
        // Process each line from the input
        while (in.hasNextLine()) {
            String line = in.nextLine().trim(); // Read and trim the line
            if (isFirstLine) { // Skip the first line
                isFirstLine = false;
                continue;
            }
            if (line.isEmpty()) continue; // Skip empty lines

            // Split the line by semicolon
            String[] data = line.split(";");
            if (data.length != 3) {
                // Invalid line format
                System.out.println("Invalid line skipped: " + line);
                continue;
            }

            String friend1 = data[0]; // First friend's name
            String friend2 = data[1]; // Second friend's name
            int strength;
            try {
                // Parse the friendship strength to integer
                strength = Integer.parseInt(data[2]);
            } catch (NumberFormatException e) {
                // Invalid strength value
                System.out.println("Invalid strength value: " + data[2]);
                continue;
            }

            // Create a new friendship and add it to the network
            Friendship friendship = new Friendship(friend1, friend2, strength);
            this.addFriendship(friendship);
        }
    }

    // Method to add a user to the social network
    public void addUser(String user) {
        // Check if the user already exists
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>()); // Add the user with an empty list of friendships
            V++; // Increment the number of users
        }
    }

    // Method to add a friendship to the social network
    public void addFriendship(Friendship f) {
        // Add the users involved in the friendship
        addUser(f.getFirstFriend());
        addUser(f.getSecondFriend());
        // Add the friendship to the adjacency list for both users
        adj.get(f.getFirstFriend()).add(f);
        // Add the friendship in reverse order basically, because a friendship is recorded in both directions
        adj.get(f.getSecondFriend()).add(new Friendship(f.getSecondFriend(), f.getFirstFriend(), f.getFriendshipStrength()));
        E++; // Increment the number of friendships
    }

    // Method to recommend friends for a given user
    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>(); // List to store recommendations
        if (!adj.containsKey(user)) return recommendations; // If the user doesn't exist, return empty list

        Map<String, Integer> potentialFriends = new HashMap<>(); // Map to store potential friends and their scores

        // Iterate through the user's friends
        for (Friendship friendShip : adj.get(user)) {
            String friend = friendShip.getSecondFriend(); // Friend's name
            int userFriendStrength = friendShip.getFriendshipStrength(); // Strength of the friendship

            // Iterate through the friend's friends
            for (Friendship friendOfFriendShip : adj.get(friend)) {
                String potentialFriend = friendOfFriendShip.getSecondFriend(); // Potential friend's name
                int friendToPotentialFriendStrength = friendOfFriendShip.getFriendshipStrength(); // Strength of the potential friendship

                // Skip if the potential friend is the user or already a direct friend
                if (potentialFriend.equals(user) || adj.get(user).stream().anyMatch(f -> f.getSecondFriend().equals(potentialFriend)))
                    continue;

                // Calculate the minimum strength and update the potential friend's score
                int minStrength = Math.min(userFriendStrength, friendToPotentialFriendStrength);
                potentialFriends.put(potentialFriend, potentialFriends.getOrDefault(potentialFriend, 0) + minStrength);
            }
        }

        // Create recommendations based on the potential friends' scores
        for (Map.Entry<String, Integer> entry : potentialFriends.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }

        // Sort the recommendations
        Collections.sort(recommendations);
        return recommendations;
    }

    // Method to get the count of users in the social network
    public int getUserCount() {
        return adj.size();
    }

    // Method to get the count of friendships in the social network
    public int getFriendshipCount() {
        int count = 0;
        // Iterate through each user's list of friendships and count them
        for (List<Friendship> friends : adj.values()) {
            count += friends.size();
        }
        return count / 2; // Each friendship is counted twice, so divide by 2
    }

    // Method to check if a user exists in the social network
    public boolean hasUser(String user) {
        return adj.containsKey(user);
    }
}
