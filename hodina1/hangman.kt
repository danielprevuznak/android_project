import java.io.File

val hangman = listOf("""
    -----
    |   |
    |   o
    |  /|\   
    |  /'\
    |
    ----------
""".trimIndent(),
"""
    -----
    |   |
    |   o
    |  /|\   
    |  / 
    |
    ----------
""".trimIndent(),
"""
    -----
    |   |
    |   o
    |  /|\   
    |  
    |
    ----------
""".trimIndent(),
"""
    -----
    |   |
    |   o
    |  /|   
    |  
    |
    ----------
""".trimIndent(),
"""
    -----
    |   |
    |   o
    |  /   
    |  
    |
    ----------
""".trimIndent(),
"""
    -----
    |   |
    |   o
    |     
    |  
    |
    ----------
""".trimIndent(),
"""
    -----
    |   
    |  
    |     
    |  
    |
    ----------
""".trimIndent(),
"""
    
    |   
    |   
    |     
    |  
    |
    ----------
""".trimIndent(),
"""
    
    ----------
""".trimIndent()
)
    

fun main(){
    val word = File("words.txt").readLines().random();
    var status = ".".repeat(word.length).toCharArray();
    var life = hangman.lastIndex;

    println(word);
    println(status);
    println(life);

    while (life > 0 && String(status) != word){
        println(status);
        println(hangman[life]);

        var input = readLine()!!

        if (input.length > 1){
            if(input == word){
                status = input.toCharArray()
            }else life--
        }else if (input in word){
            word.forEachIndexed {index, c -> 
                if (c in input){
                    status[index] = c;
                }
            }
        }else life--


        println(input)
        
    }

    println(hangman[life]);
    println("Hra ukoncena")

}