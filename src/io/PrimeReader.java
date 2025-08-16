package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import io.Versuch_023_komplett.Data;

public class PrimeReader
{
   private final String[] paths = { "primes_029_10", "primes_053_20",
         "primes_101_39", "primes_193_78", "primes_383_156", "primes_571_234",
         "primes_743_310" };

   public String readFromData()
   {
      Random random = new Random(System.nanoTime());
      String path = paths[random.nextInt(0, 6)];
      path = path + "/primes_100_" + random.nextInt(0, 10) + ".txt";
      path = Data.class.getResource(path).getFile();
          
      File file = new File(path);

      try (FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,
                  StandardCharsets.UTF_8);
            Reader reader = new BufferedReader(isr);)
      {
         StringBuffer buffer = new StringBuffer();
         String input;
         int ch;
         while ((ch = reader.read()) > -1)
         {
            buffer.append((char) ch);
         }
         reader.close();
         input = buffer.toString().trim();
         String[] rows = input.split("\n");
         String row = rows[random.nextInt(3, 102)];
         return row.split("\t")[1].strip();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

      return "Error";
   }
}
