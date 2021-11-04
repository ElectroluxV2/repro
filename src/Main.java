public class Main {
    public static void main(String[] args) {

        SearchParameters parameters = new SearchParameters();
        parameters.getFunctions().add(new FunctionsParameters("age"));

        final var items = People.Data;

        final var functionResults = parameters.getFunctions().stream()
                .map(functionsParameters -> {
                    final var fieldValuesStream = items.stream()
                            .map(person -> PersonFieldGetter.getFieldValueAsNumber(functionsParameters.getFieldName(), person))
                            .mapToDouble(Number::doubleValue);
                    // When .mapToDouble(Number::doubleValue); used:
                    // java: incompatible types: invalid method reference
                    //    method doubleValue in class java.lang.Number cannot be applied to given types
                    //      required: no arguments
                    //      found:    java.lang.Object
                    //      reason: actual and formal argument lists differ in length
                    return null;
                })
                .toList();
    }
}
