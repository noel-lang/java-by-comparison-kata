package com.javabycomparison.kata.printing;

import com.javabycomparison.kata.analysis.ResultData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class CSVPrinter {

	private final Path csvFile;

	public CSVPrinter(String outputFile) {
		this.csvFile = Paths.get(outputFile);
	}

	public void writeCSV(ResultData[] overallResult) throws IOException {
		FileOutputStream writer = new FileOutputStream(csvFile.toFile());
		writer.write(
				"File Name,Language,Lines of Code,Number of Comments,Number of Methods,Number of Imports\n"
						.getBytes());
		Arrays.stream(overallResult)
				.filter(Objects::nonNull)
				.map(
						result -> String.join(
								",",
								result.name,
								(result.type == 0) ? "Java" : "Python",
								String.valueOf(result.linesOfCode),
								String.valueOf(result.linesOfComments),
								String.valueOf(result.linesOfMethods),
								String.valueOf(result.linesOfImports))
								+ System.lineSeparator())
				.map(String::getBytes)
				.forEach(
						str -> {
							try {
								writer.write(str);
							} catch (IOException e) {
							}
						});

		writer.close();
	}
}
