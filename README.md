# instant-messenger

Team Members: Cindy Hom, Brittany Logan

Instant messenger with a GUI that allows users to communicate over the Internet. Java sockets, swing, and awt are used. 

Alice Login            |  Bob Login
:-------------------------:|:-------------------------:
![Alice Login](https://cloud.githubusercontent.com/assets/17078052/16498498/279dc1ce-3eca-11e6-9318-530192d64f47.png) | ![Bob Login](https://cloud.githubusercontent.com/assets/17078052/16498504/30987eb8-3eca-11e6-81f5-a46434bcf850.png)

Multiple participants can join and contribute to the conversation.

Join Chat               |    Chat Room Conversation
:----------------------:|:-----------------------------:
![Join Chat](https://cloud.githubusercontent.com/assets/17078052/16498538/5090d0d0-3eca-11e6-92d9-d63b0a711426.png) | ![Chat History](https://cloud.githubusercontent.com/assets/17078052/16498554/5a49cfaa-3eca-11e6-8144-25c32d30a8e8.png)

### Instructions:
1. Compile all java files. 
2. Run the ChatServer class.
3. Enter IP address, port number, and username.
4. Run the ChatClient class.
5. Enter same IP address and port number as the host. Enter your username.
6. Proceed with conversation or add more participants by repeating steps 4 & 5.
7. Send messages by typing in the text box on the bottom of the chat screen and press the "Send" button

### Overview:
Instant messenger that allows users to communicate over the Internet. Since participants communicate over the Internet, this program can be used to connect people on different computers to the same conversation. It supports group conversations in which, one user is the conversation host who initiates the conversation, and the rest of the users are participants of the conversation. The host publicly releases the IP address and port number that it uses to accept incoming connections from the participants; and a participant joins a conversatoin by indicating the IP and port numver that he wants to connect to by inputting the information into a GUI window. From the point they join, all participants and the host see the same conversation in chronological order. At the end of the conversation, participants can freely leave the conversation and if the host leaves, the conversation ends immediately even if there are still online participants.
