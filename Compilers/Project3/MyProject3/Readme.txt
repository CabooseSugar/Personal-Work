1. Compilation of this program was done via IntelliJ IDEA.
2. Create a project in IntelliJ IDEA w/ the appropriate Java Project SDK version (This was done with 1.8)
3. In the newly created project folder, copy all java files (including SyntaxChecker.java and ParserVal.java) and Lexer.flex into the "src" file in the project directory.
4. Copy all desired test files to the same location.
5. Run jflex-1.6.1
6. For lexical specification, browse to Lexer.flex and select
7. Set the output directory to the same src folder
8. Click Generate
9. Exit jflex
10. Run Program.java in IntelliJ IDEA
11. While in the code editing pane, hit CTRL + SHIFT + F10.
12. In the small menu that appears, click Edit Configurations.
13. In the Program Arguments Field in the fuller menu that appears, enter the full path of the desired test file.
   (Note: Test file paths can be easily obtained by right clicking on the test file in the left pane and clicking Copy Path)
14. Click Apply, and then OK.
15. Now run Program.java, it will return the result for that test file.
16. Repeat steps 11-16 for all test files.
