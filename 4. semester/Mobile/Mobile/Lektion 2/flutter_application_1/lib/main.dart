import 'dart:async';
import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(home: Agent()));
}

class Agent extends StatefulWidget {
  final String? agent;

  const Agent({Key? key, this.agent}) : super(key: key);

  @override
  State<Agent> createState() => _AgentState();
}

class _AgentState extends State<Agent> {
  String agent;
  final agentList = [
    "daniel_craig",
    "george_lazenby",
    "pierce_brosnan",
    "roger_moore",
    "sean_connery",
    "timothy_dalton"
  ];

  _AgentState() : agent = '';

  /* @override
  void initState() {
    super.initState();
    Timer.periodic(const Duration(seconds: 5), (times) {
      setState(() {
        agent = randomAgent();
      });
    });
  }*/

  String randomAgent() {
    var randomAgent = '';
    /* const agentList = [
      "daniel_craig",
      "george_lazenby",
      "pierce_brosnan",
      "roger_moore",
      "sean_connery",
      "timothy_dalton"
    ]; */
    final _random = Random();
    randomAgent = this.agentList[_random.nextInt(agentList.length)];

/*
    do {
randomAgent = agentList[_random.nextInt(agentList.length)];
    }
    while (randomAgent == agent)
    */

    if (randomAgent == agent) {
      randomAgent = this.randomAgent();
    }

    return randomAgent;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Double OOO Seven'),
        centerTitle: true,
        leading: IconButton(
          icon: Icon(Icons.update),
          onPressed: () => {
            setState(
              () => {agent = randomAgent()},
            )
          },
          highlightColor: Color.fromARGB(115, 166, 255, 0),
          splashColor: Colors.purple,
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(10.0),
        child: ListView.builder(
          scrollDirection: Axis.horizontal,
          itemCount: agentList.length,
          itemBuilder: (_, index) {
            return Image.asset('assets/images/agents/${agentList[index]}.png');
          },
        ),
      ),
    );
  }
}
