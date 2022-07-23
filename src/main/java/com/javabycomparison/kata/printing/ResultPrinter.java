package com.javabycomparison.kata.printing;

import com.javabycomparison.kata.analysis.ResultData;

import java.util.Arrays;

public class ResultPrinter {

	private static final String FILE_NAME = "File Name";
	private static final String LANGUAGE = "Language";
	private static final String LINES_OF_CODE = "Lines of Code";
	private static final String LINES_OF_COMMENTS = "Number of Comments";
	private static final String LINES_OF_METHODS = "Number of Methods";
	private static final String LINES_OF_IMPORTS = "Number of Imports";

	private static final String TAB_CHARACTER = "\t";

	private static final String TABLE_FORMAT = "| %-19s | %-19d | %-19d | %-19d | %-19d | %-19d |%n";
	private static final int COLUMN_WIDTH = 20;

	public static void printOverallResults(ResultData[] overallResult) {
		ResultData r1 = overallResult[0];
		ResultData r2 = overallResult[1];

		String[] headings = {
				"File Name", "Language", "Lines of Code", "Number of Comments",
				"Number of Methods", "Number of Imports"
		};

		StringBuilder headerBuilder = new StringBuilder();

		for (String heading : headings) {
			headerBuilder.append("| ");
			headerBuilder.append(heading);

			int neededSpaces = COLUMN_WIDTH - heading.length();

			if (neededSpaces > 0) {
				headerBuilder.append(String.format("%1$" + neededSpaces + "s", ""));
			}
		}

		headerBuilder.append("|%n");

		System.out.format(buildStars(headings.length));
		System.out.format(headerBuilder.toString());
		System.out.format(buildStars(headings.length));

		Arrays.stream(overallResult)
				.forEach(result -> System.out.format(TABLE_FORMAT, result.getName(), result.getType(), result.getLinesOfCode(),
						result.getLinesOfComments(), result.getLinesOfMethods(), result.getLinesOfImports()));

		System.out.format(buildStars(headings.length));


	}

	private static String buildStars(int amountOfHeadings) {
		StringBuilder starBuilder = new StringBuilder();

		for (int i = 0; i < amountOfHeadings; i++) {
			starBuilder.append("+");
			for (int j = 0; j <= COLUMN_WIDTH; j++) {
				starBuilder.append("-");
			}
		}

		starBuilder.append("+%n");

		return starBuilder.toString();
	}

	private static int calculateFileNameLength(ResultData r1, ResultData r2) {
		// returns the length of the longest string of the three
		return Math.max(
				Math.max(String.valueOf(r1.name).length(), String.valueOf(r2.name).length()),
				FILE_NAME.length());
	}

	private static int calculateLanguageLength(ResultData r1, ResultData r2) {
		String languageR1 = (r1.type == 0) ? "Java" : "Python";
		String languageR2 = (r2.type == 0) ? "Java" : "Python";

		// returns the length of the longest string of the three
		return Math.max(Math.max(languageR1.length(), languageR2.length()), LANGUAGE.length());
	}

	private static int calculateLOCLength(ResultData r1, ResultData r2) {
		// returns the length of the longest string of the three
		return Math.max(
				Math.max(String.valueOf(r1.linesOfCode).length(), String.valueOf(r2.linesOfCode).length()), LINES_OF_CODE.length());
	}

	private static int calculateCommentLOCLength(ResultData r1, ResultData r2) {
		// returns the length of the longest string of the three
		return Math.max(
				Math.max(String.valueOf(r1.linesOfComments).length(), String.valueOf(r2.linesOfComments).length()),
				LINES_OF_COMMENTS.length());
	}

	private static int calculateNumMethodsLength(ResultData r1, ResultData r2) {
		// returns the length of the longest string of the three
		return Math.max(
				Math.max(String.valueOf(r1.linesOfMethods).length(), String.valueOf(r2.linesOfMethods).length()),
				LINES_OF_METHODS.length());
	}

	private static int calculateNImportsLength(ResultData r1, ResultData r2) {
		// returns the length of the longest string of the three
		return Math.max(
				Math.max(String.valueOf(r1.linesOfImports).length(), String.valueOf(r2.linesOfImports).length()),
				LINES_OF_IMPORTS.length());
	}
}
