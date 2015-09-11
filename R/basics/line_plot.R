pdf("line_plot.pdf")
# enter datas as vector
dose  <- c(20, 30, 40, 45, 60)
drugA <- c(16, 20, 27, 40, 60)
drugB <- c(15, 18, 25, 31, 40)
# save the current graphical parameter settings
opar  <- par(no.readonly=TRUE)
# modify the default graphical parameter
par(pin=c(2, 3))
par(lwd=2, cex=1.5)
par(cex.axis=0.75, font.axis=3)

plot(dose, drugA, type="b", pch=19, lty=2, col="red",
	 main="Clinical Trials for Drug A",
	 sub="This is hypothetical data",
	 xlab="Dosage", ylab="Drug Response",
	 xlim=c(0, 60), ylim=c(0, 70))
plot(dose, drugB, type="b", pch=23, lty=6, col="blue", bg="green",
	 main="Clinical Trials for Drug B",
	 sub="This is hypothetical data",
	 xlab="Dosage", ylab="Drug Response",
	 xlim=c(0, 60), ylim=c(0, 70))
# restore the original graphical parameter settings
par(opar)
