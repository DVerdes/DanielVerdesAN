
print("------FUNCIONES------")

def Funcion1 (param):
    if param>2: return("Mayor de dos")
    else: return("No es mayor de dos")
  
n = int(input("Inserta un numero "))    
print(Funcion1(n))

def Funcion2 (param,param2="Hola",par3=2):
    print("Los parametros son:",param,param2,par3)

Funcion2("Parametro")
Funcion2(23,"Adios")

def Funcion3(*params):
    for ele in params:
        print(ele)
        
Funcion3(3,4,5,1,2,56,78)

#Funciones a listas

Lista1 = [1,2,3,4,5,6]

def cuadrado(n):
    return n*n

print(Lista1,"map: ",list(map(cuadrado,Lista1)))

#Lambda

print((lambda x:x*x)(3))


