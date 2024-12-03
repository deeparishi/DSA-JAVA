package com.deeparishi.javaapp.dsaconcepts.arraylist;

public class StringSplit {

    public static void main(String[] args) {

        String response  = """
                
                [
                  {
                    "question": "What is the primary purpose of the `setState` method in React?",
                    "options": [
                      "To update state by sending an API request",
                      "To render a new component to the DOM",
                      "To update state and re-render the component",
                      "To subscribe to state changes"
                    ],
                    "correctOption": 2
                  },
                  {
                    "question": "Which of the following is NOT a best practice for handling side effects in React?",
                    "options": [
                      "Using `useEffect` hook with a dependency array",
                      "Creating a new promise that resolves to an action",
                      "Using a context API to store global state",
                      "Passing props directly to a child component"
                    ],
                    "correctOption": 3
                  }
                ]
                
                ```
                
                Note: The options and correct answers are based on general best practices in React development, but may not be exhaustive or definitive.
                """;

        String processedResponse = extractJsonPart(response);
        System.out.println(processedResponse);
    }

    private static String extractJsonPart(String response) {
        int startIndex = response.indexOf('[');
        int endIndex = response.lastIndexOf(']');
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return response.substring(startIndex, endIndex + 1);
        }
        return "";
    }
}
