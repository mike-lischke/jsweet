/* 
 * JSweet - http://www.jsweet.org
 * Copyright (C) 2015 CINCHEO SAS <renaud.pawlak@cincheo.fr>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jsweet.test.transpiler;

import static org.junit.Assert.fail;

import org.jsweet.transpiler.ModuleKind;
import org.jsweet.transpiler.util.EvaluationResult;
import org.junit.Assert;
import org.junit.Test;

import source.calculus.Integers;

public class CalculusTests extends AbstractTest {

	@Test
	public void testCalculus() {
		try {
			TestTranspilationHandler logHandler = new TestTranspilationHandler();
			EvaluationResult r = transpiler.eval("Java", logHandler, getSourceFile(Integers.class));
			logHandler.assertReportedProblems();
			Assert.assertEquals("3", r.get("i").toString());
			Assert.assertEquals((Integer) 1, r.get("i1"));
			Assert.assertEquals((Integer) 1, r.get("i2"));
			Assert.assertEquals((Double) 1.5, r.get("f1"));
			Assert.assertEquals((Double) 1.5, r.get("f2"));
			Assert.assertEquals((Double) 7.5, r.get("f3"));
			Assert.assertEquals((Integer) 7, r.get("i3"));
			Assert.assertEquals((Integer) 7, r.get("i4"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception occured while running test");
		}
		eval(ModuleKind.none, (logHandler, r) -> {
			logHandler.assertReportedProblems();
			Assert.assertEquals("3", r.get("i").toString());
			Assert.assertEquals((Integer) 1, r.get("i1"));
			Assert.assertEquals((Integer) 1, r.get("i2"));
			Assert.assertEquals((Double) 1.5, r.get("f1"));
			Assert.assertEquals((Double) 1.5, r.get("f2"));
			Assert.assertEquals((Double) 7.5, r.get("f3"));
			Assert.assertEquals((Integer) 7, r.get("i3"));
			Assert.assertEquals((Integer) 7, r.get("i4"));
		} , getSourceFile(Integers.class));
	}

}