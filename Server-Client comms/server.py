# Musa Besmond Mabasa
# u18265163


import socket
from _thread import *	

def menu(addr):
    while True:
        
        val="-------------------------------------------\n"
        val+="This is your main menu, Select an option below...\n"
        val+="-------------------------------------------\n"
        val+="1-Add a Contact\n"
        val+="2-Delete a Contact\n"
        val+="3-Search for a Contact\n"
        val+="4-Edit a contact\n"
        val+="5-View all contacts\n"
        val+="#-Quit\n"
        val+="-> "
        addr.send(val.encode())
        choice = addr.recv(1028)
        choice = choice.decode()
        choice = choice.splitlines()
        choice=choice[0]
        print(choice)
        if(choice == '1'):
            add(addr)

        elif(choice == "2"):
            delete(addr)
        
        elif(choice == "3"):
            search(addr)
        
        elif(choice == "4"):
            edit(addr)
    
        elif(choice == "5"):
            view(addr)

        elif(choice == "#"):
            pr="\033[0;31m\nApplication is shutting down\n\033[m"
            addr.send(pr.encode())
            addr.close()
        
def view(addr):
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    val="-------------------------------------------\n"
    val+="\tViewing all contacts\n"
    val+="-------------------------------------------\n"
    addr.send(val.encode())
    with open('contacts.txt', 'r') as fr:
        lines = fr.readlines()
        goo=""
        num=1
        for line in lines:
            fields=line.split(',')
            
            
            lineNum = str(num)
            goo+=lineNum + ") "
            for field in fields:
                print(field)
                goo+=field
                goo+=" "
            goo+="\n"
            num+=1
    addr.send(goo.encode())
    




def add(addr):
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    val="-------------------------------------------\n"
    val+="\tAdding contact\n"
    val+="-------------------------------------------\n"
    addr.send(val.encode())

    askName="Enter the contact's name: "
    addr.send(askName.encode())
    name = addr.recv(1024)
    name = name.decode()
    name = name.splitlines()

    askSName="Enter the contact's surname: "
    addr.send(askSName.encode())
    surname = addr.recv(1024)
    surname = surname.decode()
    surname=surname.splitlines()

    askNum="Enter the contact's number: "
    addr.send(askNum.encode())
    num = addr.recv(1024)
    num = num.decode()
    num = num.splitlines()

    file1 = open("contacts.txt","a+")
    file1.write(name[0]+","+surname[0]+","+num[0]+"\n")
    file1.close()
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    print("Adding "+ name[0]+" "+surname[0]+" "+num[0]+" was successful")
    m = "\033[0;32m Adding "+ name[0]+" "+surname[0]+" "+num[0]+" was successful\n\033[m"
    addr.send(m.encode())

def search(addr):
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    val="-------------------------------------------\n"
    val+="\tSearching contact\n"
    val+="-------------------------------------------\n"
    addr.send(val.encode())

    askName="Enter the contact's name to search: "
    addr.send(askName.encode())
    name = addr.recv(1024)
    name = name.decode()
    name = name.splitlines()

    with open('contacts.txt') as temp:
        datafile = temp.readlines()
        var = 0
        cou = 0
    for line in datafile:
        cou +=1
        if name[0] in line:
            thatL=line.split(",")
            ANSIclear = "\033[2J"
            addr.send(ANSIclear.encode())
            ANSIclear2 = "\033[0;0H"
            addr.send(ANSIclear2.encode())
            print("returning searched contact to the client")
            goo ="\033[0;32m"+"The contact has been found. Contact number: "+ "\033[m"
            goo+=thatL[2]
            addr.send(goo.encode())
            var=1
    if(var==0):
        ANSIclear = "\033[2J"
        addr.send(ANSIclear.encode())
        ANSIclear2 = "\033[0;0H"
        addr.send(ANSIclear2.encode())
        print("searched contact is not found\n")
        goo ="\033[0;31m\n\nSorry the contact has not been found\n\033[m"
        addr.send(goo.encode())

def delete(addr):
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    val="-------------------------------------------\n"
    val+="\tDeleting contact\n"
    val+="-------------------------------------------\n"
    addr.send(val.encode())

    askName="Enter the contact's name to delete: "
    addr.send(askName.encode())
    name = addr.recv(1024)
    name = name.decode()
    name = name.splitlines()

    with open('contacts.txt') as temp:
        datafile = temp.readlines()
        var = 0
        cou = 0
        lineNum=0
    for line in datafile:
        cou +=1
        if name[0] in line:
            lineNum=cou;
            var=1
    if(var==0):
        ANSIclear = "\033[2J"
        addr.send(ANSIclear.encode())
        ANSIclear2 = "\033[0;0H"
        addr.send(ANSIclear2.encode())
        print("Contact to be deleted was not found\n")
        goo ="\033[0;31m\n\nSorry the contact has not been found\n\033[m"
        addr.send(goo.encode())
        return

    with open('contacts.txt', 'r') as fr:
        
        lines = fr.readlines()
        
        lineCount = 1
    
        with open('contacts.txt', 'w') as fw:
            for line in lines:
               
                if lineCount != lineNum:
                    fw.write(line)
                    
                lineCount += 1
    thatL=line.split(",")
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    print("The conctact is deleted")
    goo ="\033[0;32m"+"The contact has been deleted."+ "\n\033[m"
    addr.send(goo.encode())

def edit(addr):
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    val="-------------------------------------------\n"
    val+="\tEditing contact\n"
    val+="-------------------------------------------\n"
    addr.send(val.encode())

    askName="Enter the contact's name to edit: "
    addr.send(askName.encode())
    name = addr.recv(1024)
    name = name.decode()
    name = name.splitlines()

    with open('contacts.txt') as temp:
        datafile = temp.readlines()
        var = 0
        cou = 0
        lineNum=0
    for line in datafile:
        cou +=1
        if name[0] in line:
            lineNum=cou
            var=1
    if(var==0):
        ANSIclear = "\033[2J"
        addr.send(ANSIclear.encode())
        ANSIclear2 = "\033[0;0H"
        addr.send(ANSIclear2.encode())
        print("Contact to be edited was not found\n")
        goo ="\033[0;31m\n\nSorry the contact has not been found\n\033[m"
        addr.send(goo.encode())
        return

    with open('contacts.txt', 'r') as fr:
        
        lines = fr.readlines()
        
        lineCount = 1

        with open('contacts.txt', 'w') as fw:
            for line in lines:
               
                if lineCount != lineNum:
                    fw.write(line)
                else:
                    askName="Enter the new contact name: "
                    addr.send(askName.encode())
                    name = addr.recv(1024)
                    name = name.decode()
                    name = name.splitlines()

                    askSName="Enter the new contact surname: "
                    addr.send(askSName.encode())
                    surname = addr.recv(1024)
                    surname = surname.decode()
                    surname=surname.splitlines()

                    askNum="Enter the new contact number: "
                    addr.send(askNum.encode())
                    num = addr.recv(1024)
                    num = num.decode()
                    num = num.splitlines()

                    fw.write(name[0]+","+surname[0]+","+num[0]+"\n")
                    
                    print("Editing "+ name[0]+" "+surname[0]+" "+num[0]+" was successful")
                    m = "\033[0;32m adding "+ name[0]+" "+surname[0]+" "+num[0]+" was successful\n\n\033[m"
                    addr.send(m.encode())
                    
                lineCount += 1
    ANSIclear = "\033[2J"
    addr.send(ANSIclear.encode())
    ANSIclear2 = "\033[0;0H"
    addr.send(ANSIclear2.encode())
    print("The conctact has be edited")
    goo ="\033[0;32m"+"The contact has been edited sucessfully."+ "\n\033[m"
    addr.send(goo.encode())
    


        





            
# initializing socket
s = socket.socket()    
host = "127.0.1.1"
port = 88
ThreadCount = 0
 
# binding port and host
s.bind((host, port))  
 
# waiting for a client to connect
s.listen(5) 
def multi_threaded_client(c):          
    while True:
    # accept connection     
        print('got connection from addr', c)
        menu(c)
        # sending data type should be valing and encode before sending    
        c.close()
while True:
    # accept connection
    Client, address = s.accept()
    print('Connected to: ' + address[0] + ':' + str(address[1]))
    start_new_thread(multi_threaded_client, (Client, ))
    ThreadCount += 1
    print('Client Number: ' + str(ThreadCount))
s.close()