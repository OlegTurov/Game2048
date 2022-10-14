import java.util.Scanner;
import java.util.Random;
public class Game{
	public static void pole (int size, int [][] a){
		for (int v = 0;v < size;v++){
			System.out.println();
			System.out.println(" ");
			for (int s = 0;s < size;s++ ){
				System.out.print("\t" + a[v][s] + "\t");

			}
		}
	}
	public static void main(String[] args) {
		System.out.println("  Добро пожаловать в игру 2048!");
		System.out.println("  Для совершения действия используйте клавиши"+ "  w, " +"a, " +"s, " + "d.");
		System.out.println("  Перед началом игры отключите CapsLock");
		System.out.println(" ");
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		final int size = 4;
		int [][] a = new int[size][size];
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		a[y][x] = 2;
		pole(size, a);
		boolean t = true;
		while (t == true){
			System.out.println();
			String h = sc.next();
			while ((h == "w") || (h == "a") || (h == "s") || (h == "d")){
				System.out.println(" ");
				System.out.println("Введите корректную команду");
				h = sc.next();
			}
			switch (h){
				case "d":
					for (int i = 0; i < size; i++){
						for (int d = size - 1;d > 0; d--){
							if (a[i][d] == 0){
								for (int k = d - 1; k >=0; k--){
									if (a[i][k] != 0){
										a[i][d] = a[i][k];
										a[i][k] = 0;
										break;
									}
								}
							}else{
								for (int k = d - 1; k >=0; k--){
									if (a[i][d] == a[i][k]){
										a[i][d] += a[i][k];
										a[i][k] = 0;
										if (i!=0){
											i++;
										}
										break;
									}
								}
							}
						}
					}
					break;
				case "a":
					for (int i = 0; i < size; i++){
						for (int d = 0;d < size - 1 ; d++){
							if (a[i][d] == 0){
								for (int k = d + 1; k < size ; k++){
									if (a[i][k] != 0){
										a[i][d] = a[i][k];
										a[i][k] = 0;
										break;
									}
								}
							}else{
								for (int k = d + 1; k < size; k++){
									if (a[i][d] == a[i][k]){
										a[i][d] += a[i][k];
										a[i][k] = 0;
										if (i!= 0){
											i--;
										}
										break;
									}
								}
							}
						}
					}
					break;
				case "w":
					for (int d = 0;d < size;d++){
						for (int i = 0; i < size - 1; i++){
							if (a[i][d] == 0){
								for (int k = i + 1; k < size; k++){
									if (a[k][d] != 0){
										a[i][d] = a[k][d];
										a[k][d] = 0;
										break;
									}
								}
							}else{
								for (int k = i + 1; k < size; k++){
									if (a[k][d] == a[i][d]){
										a[i][d] += a[k][d];
										a[k][d] = 0;
										if (i!=0){
											i--;
										}
										break;
									}
								}
							}
						}
					}
					break;
				case "s":
					for (int d = 0;d < size;d++){
						for (int i = size - 1; i > 0; i--){
							if (a[i][d] == 0){
								for (int k = i - 1; k >= 0;k--){
									if (a[k][d] != 0){
										a[i][d] = a[k][d];
										a[k][d] = 0;
										break;
									}
								}
							}else{
								for (int k = i - 1; k >= 0; k--){
									if (a[k][d] == a[i][d]){
										a[i][d] += a[k][d];
										a[k][d] = 0;
										if (i!=0){
											i++;
										}
										break;
									}
								}
							}
						}
					}
					break;
			//конец switch 
			}
			x = r.nextInt(size);
			y = r.nextInt(size);
			while (a[y][x] != 0){
				x = r.nextInt(size);
				y = r.nextInt(size);
			}
			a[y][x] = 2;
			pole(size, a);
			//конец while
		}
	}
}