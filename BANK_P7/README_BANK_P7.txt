BANK_P7 - MiniBank Custom Annotations and Reflection

Changes:
- Added @Id, @Positive, and @MaxLength under model.annotation.
- Added @Id to Account.accountNumber, @Positive to balance, and @MaxLength(30) to ownerName.
- Added util.AnnotationValidator using reflection.
- Added a negative-balance validation test in MiniBank.main().
- Added @Override annotations to overridden methods in Account and account subclasses.
- WithdrawRule is marked @FunctionalInterface.

Compile from inside BANK_P7 (JDK 17 or newer recommended because the existing code uses records and switch expressions):
  javac -d out MiniBank.java model/*.java model/annotation/*.java service/*.java util/*.java

Run:
  java -cp out MiniBank
