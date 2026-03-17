void main() {
    String[] passwordCharacters = {"A", "B", "C", "a", "b", "c", "0", "1", "2", "!" };
    Random random = new Random();
    StringBuilder generatedPassword = new StringBuilder();

    for (int i = 0; i < 4; i++) {
        generatedPassword.append(passwordCharacters[random.nextInt(9)]);
    }
    IO.println(generatedPassword);

    String crackedPassword;
    int first = 0;
    int second = 0;
    int third = 0;
    int fourth = 0;
    boolean combinationsAvailable = true;

    while (combinationsAvailable) {
        crackedPassword = String.format("%s%s%s%s",
                passwordCharacters[first],
                passwordCharacters[second],
                passwordCharacters[third],
                passwordCharacters[fourth]
        );

        if (generatedPassword.toString().equals(crackedPassword)) {
            IO.println("I guessed the password. It is " + crackedPassword);
        }

        fourth++;
        if (fourth > 9) {
            fourth = 0;
            third++;
        }
        if (third > 9) {
            third = 0;
            second++;
        }
        if (second > 9) {
            second = 0;
            first++;
        }
        if (first == 10) combinationsAvailable = false;
    }
}
