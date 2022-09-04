/**
 * Copyright (c) 2022 aoshiguchen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package fun.asgc.neutrino.core.scheduler.test2;

import fun.asgc.neutrino.core.annotation.Bean;
import fun.asgc.neutrino.core.annotation.EnableJob;
import fun.asgc.neutrino.core.annotation.NeutrinoApplication;
import fun.asgc.neutrino.core.context.NeutrinoLauncher;
import fun.asgc.neutrino.core.quartz.DefaultJobSource;
import fun.asgc.neutrino.core.quartz.IJobExecutor;
import fun.asgc.neutrino.core.quartz.JobExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: aoshiguchen
 * @date: 2022/9/4
 */
@EnableJob
@NeutrinoApplication
public class Launcher {

	public static void main(String[] args) {
		NeutrinoLauncher.runSync(Launcher.class, args);
	}

	@Bean
	public JobExecutor jobExecutor() {
		JobExecutor executor = new JobExecutor();
		executor.setJobSource(new DefaultJobSource());
		executor.setThreadPoolExecutor(new ThreadPoolExecutor(5, 20, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>()));
		executor.setJobCallback(new JobCallback());
		return executor;
	}

}