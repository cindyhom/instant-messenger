# instant-messenger

Instant messenger that allows users to communicate over the Internet. It supports group conversations in which, one user is the conversation host who initiates the conversation, and the rest of the users are participants of the conversation. The host publicly releases the IP address and port number that it uses to accept incoming connections from the participants; and a participant joins a conversatoin by indicating the IP and port numver that he wants to connect to by inputting the information into a GUI window. All participants and the host see the same conversation in chronological order. At the end of the conversation, participants can freely leave the conversation and if the host leaves, the conversation ends immediately even if there are still online participants.

Instructions:
1. First run the Server class, using a port number (ex: 9999) as a command line argument. 
2. Then run the Client class, inputting the appropriate data when the GUI window appears.
3. Proceed to chat and/or add more participants to the conversation by repeating step 2 
