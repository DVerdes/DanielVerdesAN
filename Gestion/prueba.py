

print("------IF-----")

var1 = 0

if var1==1:
    print("Es igual a 1")
else: print("No es igual a 1")


var2 = int(input("Inserta un numero"))

if var2==1:
    print("Es igual a 1")
elif var2==0:
    print("Es igual a 0")
else: print("No es ni 1 ni 0")

print("cero" if (var2==0) else "Distinto de cero")


print("------BUCLES------")

tupla1 = (1,2,3,4,5)

print
("-----FOR------")
for ele in tupla1:
    if ele%2==0: print(str(ele)+" es par")
    else: print(str(ele)+" es impar")
    
for ele in range(1,20):
    print(ele)
    
print("-----WHILE------")

var3=0   
   
while var3<15:
    print("valor: ",var3)
    var3+=2
    
    
