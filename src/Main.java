public class Main {
    public static void main(String[] args) {

        SearchParameters parameters =new SearchParameters();
        parameters.setAgeFrom(20);
        parameters.setAgeTo(40);
        parameters.setIncomeFrom(2000);
        parameters.setPage(new Page(9,1));
        parameters.getSelectedGenders().add(Gender.FEMALE);
        parameters.getSelectedGenders().add(Gender.OTHER);
        parameters.getFunctions().add(new FunctionsParameters("age", Funcs.AVARAGE));
        parameters.getFunctions().add(new FunctionsParameters("income", Funcs.SUM));
        parameters.getFunctions().add(new FunctionsParameters("income", Funcs.AVARAGE));

        final var items = People.Data;

        final var functionResults = parameters.getFunctions().stream()
                .map(functionsParameters -> {
                    final var fieldValuesStream = items.stream()
                            .map(person -> PersonFieldGetter.getFieldValueAsNumber(functionsParameters.getFieldName(), person))
                            .mapToDouble(value -> value.doubleValue());
                    // When .mapToDouble(Number::doubleValue); used:
                    // java: incompatible types: invalid method reference
                    //    method doubleValue in class java.lang.Number cannot be applied to given types
                    //      required: no arguments
                    //      found:    java.lang.Object
                    //      reason: actual and formal argument lists differ in length
                    return new FunctionResult(
                            functionsParameters.getFunction(),
                            functionsParameters.getFieldName(),
                            switch (functionsParameters.getFunction()) {
                                case SUM -> fieldValuesStream.sum();
                                case AVARAGE -> fieldValuesStream.average().orElse(0);
                            }
                    );
                })
                .toList();
    }
}
