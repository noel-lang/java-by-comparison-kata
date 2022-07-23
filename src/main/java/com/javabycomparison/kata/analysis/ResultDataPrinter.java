package com.javabycomparison.kata.analysis;

import java.util.Collections;

public class ResultDataPrinter {

	public String print(ResultData data) {
		String language;
		if (data.type == 0) language = "Java";
		else if (data.type == 1) language = "Python";
		else language = "other";
		return data.name
				+ "\t"
				+ language
				+ "\t"
				+ data.linesOfCode
				+ "\t"
				+ data.linesOfComments
				+ "\t"
				+ data.linesOfMethods
				+ "\t"
				+ data.linesOfImports;
	}

	public String printFileName(ResultData data, int length) {
		return String.join("", Collections.nCopies(Math.max(length - data.name.length(), 0), " "))
				+ data.name;
	}

	public String printLanguage(ResultData data, int length) {
		String language;
		if (data.type == 0) language = "Java";
		else if (data.type == 1) language = "Python";
		else language = "other";
		return String.join("", Collections.nCopies(Math.max(length - language.length(), 0), " "))
				+ language;
	}

	public String printLOC(ResultData data, int length) {
		return String.join(
				"", Collections.nCopies(Math.max(length - String.valueOf(data.linesOfCode).length(), 0), " "))
				+ data.linesOfCode;
	}

	public String printCommentLOC(ResultData data, int length) {
		return String.join(
				"",
				Collections.nCopies(
						Math.max(length - String.valueOf(data.linesOfComments).length(), 0), " "))
				+ data.linesOfComments;
	}

	public String printNumMethodLOC(ResultData data, int length) {
		return String.join(
				"",
				Collections.nCopies(Math.max(length - String.valueOf(data.linesOfMethods).length(), 0), " "))
				+ data.linesOfMethods;
	}

	public String printNImportsLOC(ResultData data, int length) {
		return String.join(
				"",
				Collections.nCopies(Math.max(length - String.valueOf(data.linesOfImports).length(), 0), " "))
				+ data.linesOfImports;
	}
}
