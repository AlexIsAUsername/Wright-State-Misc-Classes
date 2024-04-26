/*
How to improve the Caeser Cypher

This could by done by having the key be used as a seed to generate random numbers to shift each character by.
We could also remove the limitation of needing the letters remain letters.
We could also allow the punctuation to also rotate with the letters.
*/
#include <iostream>
#include <string>

int main()
{
    // reading in plain plainText from user
    std::string plainText;
    std::cout << "Enter plain text: ";
    getline(std::cin, plainText);
    char cypherText[plainText.length() + 1];
    // for (int i = 0; i < plainText.size(); i++)
    // {
    //     cypherText[i] = plainText[i];
    // }
    strcpy(cypherText, plainText.c_str());

    // reading in key from user
    int key;
    std::cout << "Enter key: ";
    std::cin >> key;

    /*
     * 0 = punctuation (default assumption)
     * 1 = upper case
     * 2 = lower case
     */
    int changeArr[sizeof(cypherText) + 1];
    std::fill_n(changeArr, sizeof(cypherText), 0);
    for (int i = 0; i < sizeof(cypherText); i++)
    {
        char check = cypherText[i];
        if (check >= 65 && check <= 90)
            changeArr[i] = 1;
        else if (check >= 97 && check <= 122)
            changeArr[i] = 2;
    }

    // makes all upper case
    for (int i = 0; i < sizeof(cypherText); i++)
    {
        if (changeArr[i] == 2)
            cypherText[i] -= 32;
    }

    int rotate = -key % 26; // reduce to minimum rotation amount

        for (int i = 0; i < sizeof(cypherText); i++)
    {
        if (changeArr[i] == 0)
        {
        }
        else
        {
            cypherText[i] += rotate; // rotate characters
            char check = cypherText[i];
            // fix out of letter bounds
            if (check < 'A')
                cypherText[i] += 26;
            else if (check > 'Z')
                cypherText[i] -= 26;
        }
    }

    // fixes uppercase
    for (int i = 0; i < sizeof(cypherText); i++)
    {
        if (changeArr[i] == 2)
            cypherText[i] += 32;
    }

    // printing out
    std::cout << cypherText << "\n";

    return 0;
}