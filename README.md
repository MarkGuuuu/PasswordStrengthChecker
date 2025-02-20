# Password Strength Checker

This is a Java project, password strength evaluation tool that helps people how password strength is being determined and understand the security level of their passwords.

## What it Does

This program evaluates password strength based on multiple rules:
- Length Requirement: Minimum length 8+ characters
- Variety of Characters: Uppercase letter, Lowercase letter, numeric numbers and special characters.
- Repeated character detection
- Common pattern detection (e.g. "1234567890", "password", "qwert")

How this program shows password strength:
- Visual strength bar
- Password strength score and Detailed feedback for improvement

## How to run the program and necessary dependencies.

### Requirements
- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or Eclipse IDE
- might require to have git or GitHub desktop on your computer

### How to Run

1. Clone the repo in IntelliJ IDEA or Eclipse IDE

2. Simply run CheckingPasswordSafety.java

3. In the output window, follow the direction to enter passwords for evaluation.

4. Type 'quit' (case not sensitive) to exit the program.

## Limitations and Disclaimers

⚠️ **IMPORTANT: This tool is for educational and demonstration purposes only.**

Limitations:
- It doesn't ensure complete password protection.
- It's unable to identify every potential password weakness.
- The rating system is basic and might not match actual security requirements.
- It shouldn't be the only method for assessing passwords in operational environments.
- The tool does not verify passwords against previously breached data or rainbow tables.
- There is no implementation of password encryption or secure storage within the tool.

## Ethical Considerations and Responsible Use

### Potential Misuse Concerns
1. **False Sense of Security**: Users might assume a "strong" password rating means their password is completely secure. All passwords can potentially be compromised in the real life.

2. **Handling of Passwords**: This tool does not provide secure storage or management of passwords. You should avoid sharing actual passwords via this tool.

3. **Risk of Code Alterations**: The code could be modified to:
    - Collect the passwords inputted
    - Generate predictable password patterns
    - Produce weak passwords that seem robust

### Responsible Usage Guidelines
1. Use this tool for learning purpose about password security concepts only.
2. Never enter real, in-use passwords.
3. Do not modify the tool to weaken its security checks.
4. Do not use this tool for security compliance or certification.

### Best Practices for Real Password Security
- Use a reputable password manager
- Avoid using the same password for multiple accounts
- Activate two-factor authentication wherever possible
- Frequently change passwords

## Contributing

If you'd like to contribute to this project, here are the rules:
1. Please review the ethical considerations above
2. Make sure changes do not undermine security protocols
3. Document any changes thoroughly

## License

[MIT License]

## Author

[Markeya(Mark) Gu]