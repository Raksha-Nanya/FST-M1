player1 = input("Please enter the player1 name ")
player2 = input("Please enter the player2 name ")

player1Answer = input(player1 +" Do you want to select Rock or Paper or Scissors: " )
player2Answer = input(player2 +" Do you want to select  Rock or Paper or Scissors: ")

if player1Answer==player2Answer:
    print("It's a tie")

elif player1Answer == 'Rock':
    if player2Answer == 'Scissors':
     print(player1 + " - Rock wins")
    else:
        print(player2 + " - Paper wins")

elif player1Answer == 'Scissors':
    if player2Answer == 'Paper':
         print(player1 + "Scissors wins")
    else:
        print(player2 + " - Rock wins")
elif player1Answer== "Paper":
    if player2Answer == "Rock":
        print(player1+ " - Paper wins")
    else:
        print(player2 + " - Scissors wins")

else:
    print("one of the player have given invalid input")



    


